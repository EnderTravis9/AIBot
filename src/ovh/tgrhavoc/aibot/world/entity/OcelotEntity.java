/*******************************************************************************
 *     Copyright (C) 2015 Jordan Dalton (jordan.8474@gmail.com)
 *
 *     This program is free software; you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation; either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License along
 *     with this program; if not, write to the Free Software Foundation, Inc.,
 *     51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *******************************************************************************/
package ovh.tgrhavoc.aibot.world.entity;

import ovh.tgrhavoc.aibot.IntHashMap;
import ovh.tgrhavoc.aibot.world.World;

public class OcelotEntity extends TameableEntity {
	private int skinType;

	public OcelotEntity(World world, int id) {
		super(world, id);
	}

	@Override
	public boolean isAggressive() {
		return false;
	}

	public int getSkinType() {
		return skinType;
	}

	@Override
	public void setAggressive(boolean aggressive) {
	}

	public void setSkinType(int skinType) {
		this.skinType = skinType;
	}

	@Override
	public void updateMetadata(IntHashMap<WatchableObject> metadata) {
		super.updateMetadata(metadata);
		if(metadata.containsKey(16)) {
			byte flags = (Byte) metadata.get(16).getObject();
			setSitting((flags & 1) != 0);
			setTamed((flags & 2) != 0);
		}

		if(metadata.containsKey(17))
			setOwnerName((String) metadata.get(17).getObject());
		if(metadata.containsKey(18))
			setSkinType((Integer) metadata.get(18).getObject());
	}
}
