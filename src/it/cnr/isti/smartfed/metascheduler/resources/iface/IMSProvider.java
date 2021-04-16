/*
Copyright 2014 ISTI-CNR
 
This file is part of SmartFed.

SmartFed is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
 
SmartFed is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.
 
You should have received a copy of the GNU General Public License
along with SmartFed. If not, see <http://www.gnu.org/licenses/>.

*/

package it.cnr.isti.smartfed.metascheduler.resources.iface;

import it.cnr.isti.smartfed.metascheduler.resources.MSProviderComputing;
import it.cnr.isti.smartfed.metascheduler.resources.MSProviderNetwork;
import it.cnr.isti.smartfed.metascheduler.resources.MSProviderStorage;

import java.util.HashMap;

import org.jgap.IApplicationData;


public interface IMSProvider extends IApplicationData{

	public void setID(int id);
	public int getID();

	//testing
	public void setCharacteristic(HashMap<String, Object> characteristic);
	public HashMap<String, Object> getCharacteristic();
		
	public void setNetwork(MSProviderNetwork network);
	public void setComputing(MSProviderComputing computing);
	public void setStorage(MSProviderStorage storage);
	
	public MSProviderComputing getComputing();
	public MSProviderStorage getStorage();
	public MSProviderNetwork getNetwork();
}
