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

package uk.jamierocks.lexlauncher;

import static com.google.common.base.Preconditions.checkNotNull;

import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;
import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.jamierocks.lexlauncher.state.LoadingState;

public final class LexLauncher {

    public static final Logger log = LoggerFactory.getLogger("LexLauncher");
    private static LexLauncher $;

    public static LexLauncher getLexLauncher() {
        checkNotNull($, "LexLauncher has not yet been initialised!");
        return $;
    }

    private final StateMachine<State, Trigger> stateMachine;
    private final EventBus eventBus = new EventBus();
    private final Injector injector;

    @Inject
    protected LexLauncher(Injector injector) {
        log.info("Starting LexLauncher 1.0.0...");

        // Set the instance
        $ = this;

        // Initialise fields
        this.injector = injector;

        // Configure state machine
        final StateMachineConfig<State, Trigger> stateMachineConfig = new StateMachineConfig<>();

        stateMachineConfig.configure(State.STARTING)
                .permit(Trigger.BEGIN, State.LOADING);

        final LoadingState loadingState = this.injector.getInstance(LoadingState.class);
        stateMachineConfig.configure(State.LOADING)
                .onEntry(loadingState::onEntry)
                .onExit(loadingState::onExit);

        this.stateMachine = new StateMachine<>(State.STARTING, stateMachineConfig);
        this.stateMachine.fire(Trigger.BEGIN);
    }

    public EventBus getEventBus() {
        return this.eventBus;
    }

    public enum State {

        STARTING,
        LOADING,
        ;

    }

    public enum Trigger {

        BEGIN,
        ;

    }

}
