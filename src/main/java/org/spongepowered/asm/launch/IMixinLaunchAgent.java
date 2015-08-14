/*
 * This file is part of Mixin, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
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
package org.spongepowered.asm.launch;

import net.minecraft.launchwrapper.LaunchClassLoader;

/**
 * Base interface for launch agents. Launch agents are environment-specific
 * launch handlers which are used by the {@link MixinTweaker mixin tweaker} to
 * perform launch tasks required by that environment without having to fill the
 * tweaker itself with a bunch of environment-specific cruft.
 * 
 * <p>Agents handle mixin environment launch tasks on a per-container basis,
 * with each container in the environment being assigned one of each available
 * type of agent to handle those tasks on behalf of the container.</p>
 */
interface IMixinLaunchAgent {
    
    /**
     * Called during pre-initialisation, after all tweakers and tweak containers
     * have been added to the environment.
     */
    public abstract void prepare();
    
    /**
     * Called from <tt>injectIntoClassLoader</tt> in the parent tweaker
     * 
     * @param classLoader
     */
    public abstract void injectIntoClassLoader(LaunchClassLoader classLoader);
    
    /**
     * Get the launch target from this container, should return null if no
     * custom target is available.
     */
    public abstract String getLaunchTarget();
}
