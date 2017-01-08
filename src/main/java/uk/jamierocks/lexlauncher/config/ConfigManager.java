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

package uk.jamierocks.lexlauncher.config;

import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.gson.GsonConfigurationLoader;
import uk.jamierocks.lexlauncher.LexLauncher;

import java.io.IOException;
import java.nio.file.Path;

public class ConfigManager {

    private final GsonConfigurationLoader loader;
    private ConfigurationNode configurationNode;

    public ConfigManager(Path configPath) {
        this.loader = GsonConfigurationLoader.builder()
                .setPath(configPath)
                .setIndent(4)
                .build();

        try {
            this.configurationNode = this.loader.load();
        } catch (IOException e) {
            this.configurationNode = this.loader.createEmptyNode();
        }
    }

    public ConfigurationNode getConfigurationNode() {
        return this.configurationNode;
    }

    public void save() {
        try {
            this.loader.save(this.configurationNode);
        } catch (IOException e) {
            LexLauncher.log.error("Failed to save config!", e);
        }
    }

}
