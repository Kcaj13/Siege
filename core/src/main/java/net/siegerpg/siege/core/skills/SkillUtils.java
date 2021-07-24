package net.siegerpg.siege.core.skills;

import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.skills.implemented.archer.CriticalShot;

import java.util.ArrayList;
import java.util.HashMap;

public class SkillUtils {

    static ArrayList<Skill> archerSkills = new ArrayList<>(){
        {
            add(new CriticalShot());
        }
    };
    static ArrayList<Skill> warriorSkills = new ArrayList<>(){
        {
        }
    };
    static ArrayList<Skill> mageSkills = new ArrayList<>(){
        {
        }
    };
    static ArrayList<Skill> heavySkills = new ArrayList<>(){
        {
        }
    };
    static HashMap<Character, ArrayList<Skill>> skillTypes = new HashMap<>(){
        {
            put('A', archerSkills);
        }
    };

    // Takes string code i.e. "A_1_4_7" and returns hashmap of skills
    public static HashMap<Integer, Skill> decode(String code) {
        HashMap<Integer, Skill> map = new HashMap<Integer, Skill>(); // HashMap to return
        ArrayList<Skill> arr = skillTypes.get(code.charAt(0));
        int indexNum = 0; // ID of skill
        // Start loop at index 2 and iterate by twos across the string
        for (int i = 2; i < code.length(); i += 2) {
            indexNum = code.charAt(i); // IDs will be at even locations
            map.put(indexNum, arr.get(indexNum)); // Update return hashmap
        }
        return map;
    }

    // Takes hashmap from decode and returns total stat change from skills in the form of a hashmap
    public static HashMap<StatTypes, Double> getStats(HashMap<Integer, Skill> decoded) {
        HashMap<StatTypes, Double> map; // HashMap to return
        // Init with zero values
        map = new HashMap<>(){
            {
                put(StatTypes.LUCK, 0.0);
                put(StatTypes.STRENGTH, 0.0);
                put(StatTypes.TOUGHNESS, 0.0);
                put(StatTypes.HEALTH, 0.0);
                put(StatTypes.REGENERATION, 0.0);
                put(StatTypes.MANA, 0.0);
                put(StatTypes.MANA_REGEN, 2.0);
            }
        };
        // Loop across every entry in the decoded map
        for (HashMap.Entry<Integer, Skill> entry : decoded.entrySet()) {
            Skill value = entry.getValue(); // get value of each entry
            HashMap<StatTypes,Double> skillStats = value.STATS; // get the stat changes for each entry
            // Loop across every stat change in an entry
            assert skillStats != null;
            for (HashMap.Entry<StatTypes, Double> vEntry : skillStats.entrySet()) {
                map.replace(vEntry.getKey(), value.STATS.get(vEntry.getKey()) + vEntry.getValue()); // Update return hashmap
            }
        }
        return map;
    }
}