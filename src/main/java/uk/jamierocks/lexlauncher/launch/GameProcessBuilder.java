/*
 * This file is part of LexLauncher, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014-2016, Jamie Mansfield <https://github.com/jamierocks>
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
package uk.jamierocks.lexlauncher.launch;

import com.google.common.collect.Lists;
import net.minecraft.launchwrapper.AlphaVanillaTweaker;
import net.minecraft.launchwrapper.IndevVanillaTweaker;
import net.minecraft.launchwrapper.VanillaTweaker;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class GameProcessBuilder {

    private VersionType versionType;
    private File gameDir;
    private File assetsDir;
    private String username;
    private String sessionId;

    public GameProcessBuilder versionType(VersionType versionType) {
        this.versionType = versionType;
        return this;
    }

    public GameProcessBuilder gameDir(File gameDir) {
        this.gameDir = gameDir;
        return this;
    }

    public GameProcessBuilder assetsDir(File assetsDir) {
        this.assetsDir = assetsDir;
        return this;
    }

    public GameProcessBuilder username(String username) {
        this.username = username;
        return this;
    }

    public GameProcessBuilder sessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public Process build() throws IOException {
        List<String> arguments = Lists.newArrayList();

        // TODO

        ProcessBuilder processBuilder = new ProcessBuilder(arguments);
        processBuilder.directory(this.gameDir);

        return processBuilder.start();
    }

    public enum VersionType {
        INDEV(IndevVanillaTweaker.class),
        ALPHA(AlphaVanillaTweaker.class),
        VANILLA(VanillaTweaker.class);

        private final Class tweakClass;

        VersionType(Class tweakClass) {
            this.tweakClass = tweakClass;
        }

        public Class getTweakClass() {
            return this.tweakClass;
        }
    }
}
