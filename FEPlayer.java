package me.ItsDanniey1.FallingEdge;

import me.ItsDanniey1.FallingEdge.Cache;


public class FEPlayer {

	private String name;
	private int kills;
	private int deaths;
	private int powerupsUsed;

	public FEPlayer(String name) {
		this.name = name;
		this.kills = 0;
		this.deaths = 0;
		this.powerupsUsed = 0;
	}
	
	public int addKill() {
		this.kills = this.kills+1;
		return this.kills;
	}
	
	public int addDeath() {
		this.deaths = this.deaths+1;
		return this.deaths;
	}
	
	public int addPowerup() {
		this.powerupsUsed = this.powerupsUsed+1;
		return this.powerupsUsed;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getKills() {
		return this.kills;
	}
	
	public int getDeaths() {
		return this.deaths;
	}
	
	public int getPowerupsUsed() {
		return this.powerupsUsed;
	}
	
	public void save() {
		Cache.FEPlayers.put(this.name, this);
	}
}
 
