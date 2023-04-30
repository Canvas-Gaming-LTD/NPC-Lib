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

package com.github.juliarn.npclib.bukkit;

import com.github.juliarn.npclib.api.NpcActionController;
import com.github.juliarn.npclib.api.NpcTracker;
import com.github.juliarn.npclib.api.PlatformTaskManager;
import com.github.juliarn.npclib.api.PlatformVersionAccessor;
import com.github.juliarn.npclib.api.PlatformWorldAccessor;
import com.github.juliarn.npclib.api.event.NpcEvent;
import com.github.juliarn.npclib.api.log.PlatformLogger;
import com.github.juliarn.npclib.api.profile.ProfileResolver;
import com.github.juliarn.npclib.api.protocol.PlatformPacketAdapter;
import com.github.juliarn.npclib.common.platform.CommonPlatform;
import net.kyori.event.EventBus;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BukkitPlatform extends CommonPlatform<World, Player, ItemStack, Plugin> {

  public BukkitPlatform(
    boolean debug,
    @NotNull Plugin extension,
    @NotNull PlatformLogger logger,
    @NotNull NpcTracker<World, Player, ItemStack, Plugin> npcTracker,
    @NotNull ProfileResolver profileResolver,
    @NotNull PlatformTaskManager taskManager,
    @Nullable NpcActionController actionController,
    @NotNull PlatformVersionAccessor versionAccessor,
    @NotNull EventBus<NpcEvent> eventBus,
    @NotNull PlatformWorldAccessor<World> worldAccessor,
    @NotNull PlatformPacketAdapter<World, Player, ItemStack, Plugin> packetAdapter
  ) {
    super(debug, extension, logger, npcTracker, profileResolver, taskManager, actionController, versionAccessor,
      eventBus, worldAccessor, packetAdapter);
  }
}
