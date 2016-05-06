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
package uk.jamierocks.lexlauncher.data;

import java.util.Optional;

/**
 * Represents a modpack.
 *
 * Example:
 * <pre>
 *     {
 *         "name": "Example Pack",
 *         "id": "example-pack",
 *         "version": "1.0.0",
 *         "channel": "RELEASE",
 *         "minecraft": {
 *             "version": "1.8.9",
 *             "json": "https://rawgit.com/MinecraftForge/MinecraftForge/master/jsons/1.8.9.json"
 *         }
 *     }
 * </pre>
 */
public class Modpack {

    private String name;
    private String id;
    private String version;
    private Channel channel;
    private MinecraftOptions minecraft;
    private String mainClass;
    private String extraArguments;

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getVersion() {
        return this.version;
    }

    public MinecraftOptions getMinecraft() {
        return this.minecraft;
    }

    public String getMainClass() {
        // TODO: null check, else get from minecraft json
        return this.mainClass;
    }

    public Optional<String> getExtraArguments() {
        return Optional.ofNullable(this.extraArguments);
    }

    public class MinecraftOptions {

        private String version;
        private String json;

        public String getVersion() {
            return this.version;
        }

        public String getJson() {
            if (this.json != null) {
                return this.json;
            } else {
                return "https://s3.amazonaws.com/Minecraft.Download/versions/" +
                        this.version + "/" + this.version + ".json";
            }
        }
    }

    enum Channel {
        RELEASE,
        BETA
    }
}
