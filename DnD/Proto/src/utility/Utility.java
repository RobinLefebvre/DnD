package utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Utility {
	public static String pickRandom(List<String> list){
		Random rng = new Random();
		int next = rng.nextInt(list.size());
		return list.get(next);
	}
	
	public static void switchCase (List<String> list){
		for(String s : list){
			System.out.println("case \"" + s + "\" :\n    break;\n");
		}
	}
	public static void ifCase (String variableName, List<String> list){
		for(String s : list){
			System.out.println("if("+ variableName+" == \"" + s + "\" ){\n    }\n");
		}
	}
	public static String mapMapIntegerToJSON(boolean display, Map<String, Map<String,Integer>> map){
		String ret = "{\n";
		for(String s : map.keySet())
		{
			ret += "    \"" + s + "\" : \n     {\n";
			HashMap<String, Integer> m = (HashMap<String, Integer>) map.get(s);
			for(String s2 : m.keySet()){
				ret += "         \"" + s2 + "\" : ";
				ret += "\"" + m.get(s2) + "\",\n";
			}
			ret += "    },\n";
		}
		ret += "}";
		ret = ret.replace(",\n    ]", "\n    ]");
		ret = ret.replace(",\n    }", "\n    }");
		ret = ret.replace(",\n}", "\n}");
		return ret;
	}
	public static String mapMapIntegerArrayToJSON(boolean display, Map<String, Map<String, int[]>> map) {
		String ret = "{\n";
		for(String s : map.keySet())
		{
			ret += "    \"" + s + "\" : \n     {\n";
			HashMap<String, int[]> m = (HashMap<String, int[]>) map.get(s);
			for(String s2 : m.keySet()){
				ret += "         \"" + s2 + "\" : [";
				for(int i =0; i< m.get(s2).length; i++){
					ret += "" + m.get(s2)[i] + ",";
				}
				ret+= "],\n";
			}
			ret += "    },\n";
		}
		ret += "}";
		ret = ret.replace(",\n    ]", "\n    ]");
		ret = ret.replace(",\n    }", "\n    }");
		ret = ret.replace(",\n}", "\n}");
		ret = ret.replace(",]", "]");
		return ret;
	}
	public static String mapMapStringToJSON(boolean display, Map<String, Map<String,String>> map){
		String ret = "{\n";
		for(String s : map.keySet())
		{
			ret += "    \"" + s + "\" : \n     {\n";
			HashMap<String, String> m = (HashMap<String, String>) map.get(s);
			for(String s2 : m.keySet()){
				ret += "         \"" + s2 + "\" : ";
				ret += "\"" + m.get(s2) + "\",\n";
			}
			ret += "    },\n";
		}
		ret += "}";
		ret = ret.replace(",\n    ]", "\n    ]");
		ret = ret.replace(",\n    }", "\n    }");
		ret = ret.replace(",\n}", "\n}");
		return ret;
	}
	public static String mapIntegerToJSON(boolean display, Map<String, Integer> map){
		String ret = "{\n";
		for(String s : map.keySet())
		{
			ret += "    \"" + s + "\" : \n     [\n";
			ret += "          \"" + map.get(s) + "\",\n";
			ret += "    ],\n";
			
		}
		ret += "}";
		ret = ret.replace(",\n    ]", "\n    ]");
		ret = ret.replace(",\n}", "\n}");
		return ret;
	}
	public static String mapStringArrayToJSON(boolean display, Map<String, String[]> map){
		String ret = "{\n";
		for(String s : map.keySet())
		{
			ret += "    \"" + s + "\" : \n     [\n";
			for(String val : map.get(s)){
				ret += "          \"" + val + "\",\n";
			}
			
			ret += "    ],\n";
			
		}
		ret += "}";
		ret = ret.replace(",\n    ]", "\n    ]");
		ret = ret.replace(",\n}", "\n}");
		return ret;
	}
	
	public static String mapListToJSON(boolean display, Map<String, List<String>> map){
		String ret = "{\n";
		for(String s : map.keySet())
		{
			ret += "    \"" + s + "\" : \n     [\n";
			for(String val : map.get(s)){
				ret += "          \"" + val + "\",\n";
			}
			ret += "    ],\n";
			
		}
		ret += "}";
		ret = ret.replace(",\n    ]", "\n    ]");
		ret = ret.replace(",\n}", "\n}");
		return ret;
	}
	
	public static String listToJSON (boolean display, List<String> list){
		String ret = "[\n";
		int i = 0;
		for(String string : list){
			ret += "    \"" + string + "\"";
			if(i != list.size() -1)
				ret += ", ";
			ret += "\n";
			i++;
		}
		ret += "]";
		return ret;
	}
	
}
