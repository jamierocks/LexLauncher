/*
 * This file is part of LexLauncher, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014-2017, Jamie Mansfield <https://github.com/jamierocks>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package uk.jamierocks.lexlauncher.service.account;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.SimpleConfigurationNode;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import uk.jamierocks.lexlauncher.LexLauncher;
import uk.jamierocks.lexlauncher.config.ConfigManager;

import java.net.Proxy;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class AccountService {

    private final ConfigManager configManager;
    private YggdrasilAuthenticationService authenticationService;
    private List<Account> accounts;
    private Optional<Account> selectedAccount;

    @Inject
    public AccountService(ConfigManager configManager) {
        this.configManager = configManager;
        this.authenticationService = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "1");
        this.accounts = configManager.getConfigurationNode().getNode("accounts").getChildrenList()
                .stream().map(Account::new).collect(Collectors.toList());
        this.selectedAccount = this.accounts.stream().filter(account -> {
            return account.getUsername().equalsIgnoreCase(configManager.getConfigurationNode().getNode("selectedAccount").getString());
        }).findFirst();
    }

    public YggdrasilUserAuthentication login(Account account) {
        final YggdrasilUserAuthentication userAuthentication =
                (YggdrasilUserAuthentication) authenticationService.createUserAuthentication(Agent.MINECRAFT);

        userAuthentication.setUsername(account.getUsername());
        userAuthentication.setPassword(account.getPassword());

        try {
            userAuthentication.logIn();
        } catch (AuthenticationException e) {
            LexLauncher.log.error("Failed to login to account: " + account.getUsername(), e);
        }

        return userAuthentication;
    }

    public Optional<Account> getSelectedAccount() {
        return this.selectedAccount;
    }

    public void selectAccount(String username) {
        this.selectedAccount = this.accounts.stream().filter(account -> {
            return account.getUsername().equalsIgnoreCase(username);
        }).findFirst();
        this.configManager.getConfigurationNode().getNode("selectedAccount").setValue(username);
        this.configManager.save();
    }

    public void addAccount(Account account) {
        this.accounts.add(account);

        final ConfigurationNode configurationNode = SimpleConfigurationNode.root();
        configurationNode.getNode("username").setValue(account.getUsername());
        configurationNode.getNode("password").setValue(account.getPassword());
        try {
            this.configManager.getConfigurationNode().getNode("accounts").getList(TypeToken.of(ConfigurationNode.class)).add(configurationNode);
        } catch (ObjectMappingException e) {
            LexLauncher.log.error("Failed to add account to config!", e);
        }
        this.configManager.save();
    }

}
