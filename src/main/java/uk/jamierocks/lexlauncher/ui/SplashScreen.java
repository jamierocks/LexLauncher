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

package uk.jamierocks.lexlauncher.ui;

import uk.jamierocks.lexlauncher.LexLauncher;
import uk.jamierocks.lexlauncher.Main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JWindow;

public class SplashScreen extends JWindow {

    private static BufferedImage splashImage;

    static {
        try {
            splashImage = ImageIO.read(Main.class.getResourceAsStream("/image/SplashScreen.png"));
        } catch (IOException e) {
            LexLauncher.log.error("Failed to get splash image!", e);
            splashImage = null;
        }
    }

    public SplashScreen() {
        this.setSize(splashImage.getWidth(), splashImage.getHeight());
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(false);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(splashImage, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    public void close() {
        this.setVisible(false);
        this.dispose();
    }

}
