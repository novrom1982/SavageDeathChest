package com.winterhavenmc.deathchest.plugin.tasks;

import com.winterhavenmc.deathchest.plugin.PluginMain;
import com.winterhavenmc.deathchest.plugin.chests.deployment.DeploymentFactory;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;


public final class DeployChestTask extends BukkitRunnable
{
	private final PluginMain plugin;
	private final Player player;
	private final Collection<ItemStack> droppedItems;
	private final Location originLocation;
	private final Player killer;


	public DeployChestTask(final PluginMain plugin, final Player player, final Collection<ItemStack> droppedItems)
	{
		this(plugin, player, droppedItems, player.getLocation(), player.getKiller());
	}


	public DeployChestTask(final PluginMain plugin, final Player player, final Collection<ItemStack> droppedItems, final Location originLocation)
	{
		this(plugin, player, droppedItems, originLocation, player.getKiller());
	}


	public DeployChestTask(final PluginMain plugin, final Player player, final Collection<ItemStack> droppedItems, final Location originLocation, final Player killer)
	{
		this.plugin = plugin;
		this.player = player;
		this.droppedItems = droppedItems;
		this.originLocation = originLocation;
		this.killer = killer;
	}


	@Override
	public void run()
	{
		plugin.chestManager.getDeploymentFactory().createDeployment(plugin, player, droppedItems, originLocation, killer).deploy();
	}

}
