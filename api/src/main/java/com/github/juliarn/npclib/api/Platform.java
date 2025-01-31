/*
 * This file is part of npc-lib, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2022-2023 Julian M., Pasqual K. and contributors
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

package com.github.juliarn.npclib.api;

import com.github.juliarn.npclib.api.event.NpcEvent;
import com.github.juliarn.npclib.api.log.PlatformLogger;
import com.github.juliarn.npclib.api.profile.ProfileResolver;
import com.github.juliarn.npclib.api.protocol.PlatformPacketAdapter;
import java.util.Optional;
import java.util.function.Consumer;
import net.kyori.event.EventBus;
import org.jetbrains.annotations.NotNull;

public interface Platform<W, P, I, E> {

  boolean debug();

  @NotNull E extension();

  @NotNull PlatformLogger logger();

  @NotNull EventBus<NpcEvent> eventBus();

  @NotNull NpcTracker<W, P, I, E> npcTracker();

  @NotNull ProfileResolver profileResolver();

  @NotNull PlatformTaskManager taskManager();

  @NotNull Npc.Builder<W, P, I, E> newNpcBuilder();

  @NotNull PlatformVersionAccessor versionAccessor();

  @NotNull PlatformWorldAccessor<W> worldAccessor();

  @NotNull PlatformPacketAdapter<W, P, I, E> packetFactory();

  @NotNull Optional<NpcActionController> actionController();

  interface Builder<W, P, I, E, B extends Platform<W, P, I, E>, S extends Builder<W, P, I, E, B, S>> {

    @NotNull S debug(boolean debug);

    @NotNull S extension(@NotNull E extension);

    @NotNull S logger(@NotNull PlatformLogger logger);

    @NotNull S eventBus(@NotNull EventBus<NpcEvent> eventBus);

    @NotNull S npcTracker(@NotNull NpcTracker<W, P, I, E> npcTracker);

    @NotNull S taskManager(@NotNull PlatformTaskManager taskManager);

    @NotNull S profileResolver(@NotNull ProfileResolver profileResolver);

    @NotNull S worldAccessor(@NotNull PlatformWorldAccessor<W> worldAccessor);

    @NotNull S versionAccessor(@NotNull PlatformVersionAccessor versionAccessor);

    @NotNull S packetFactory(@NotNull PlatformPacketAdapter<W, P, I, E> packetFactory);

    @NotNull S actionController(@NotNull Consumer<NpcActionController.Builder> decorator);

    @NotNull
    S self();

    @NotNull B build();
  }
}
