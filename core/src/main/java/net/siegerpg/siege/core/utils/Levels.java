package net.siegerpg.siege.core.utils;

import net.siegerpg.siege.core.database.DatabaseManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Levels {
    public static double calculateRequiredExperience(short level) {
        return Math.pow(level + 3, 3);
    }

    public static void levelCalculate(OfflinePlayer player) {
        short level = getLevel(player);
        int exp = getExp(player);
        while (calculateRequiredExperience(level) <= exp) { //Loops until required exp is greater than current exp
            exp -= calculateRequiredExperience(level); //Removes required exp of the level from current exp
            level += 1;
        }
        if (getExp(player) != exp) {
            setExp(player, exp); //When while loop is finished, set the temp exp variable to remaining exp
        }
        if (getLevel(player) != level) {
            setLevel(player, level); //When while loop is finished, set the temp level variable to player's level
        }

        if (player.isOnline()) {
            ((Player) player).setLevel(level);
            ((Player) player).setExp((float) (exp / calculateRequiredExperience(level)));
        }
    }

    public static double getExpCeiling(OfflinePlayer player) {
        return Math.pow((Levels.getLevel(player) + 3), 3);
    }

    public static short getLevel(OfflinePlayer player) {
        try {
            Connection connection = DatabaseManager.INSTANCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT level FROM userData WHERE uuid=?");
            statement.setString(1, player.getUniqueId().toString());
            ResultSet query = statement.executeQuery();
            query.next();
            return query.getShort("level");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void setLevel(OfflinePlayer player, short level) {
        try {
            Connection connection = DatabaseManager.INSTANCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE userData SET level=? WHERE uuid=?");
            statement.setShort(1, level);
            statement.setString(2, player.getUniqueId().toString());
            statement.executeUpdate();
            if (player.isOnline()) ((Player) player).setLevel(level);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addLevel(OfflinePlayer player, short level) {
        try {
            Connection connection = DatabaseManager.INSTANCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE userData SET level=level+? WHERE uuid=?");
            statement.setShort(1, level);
            statement.setString(2, player.getUniqueId().toString());
            statement.executeUpdate();
            levelCalculate(player);
            if (player.isOnline()) ((Player) player).setLevel(level);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Integer getExp(OfflinePlayer player) {
        try {
            Connection connection = DatabaseManager.INSTANCE.getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT experience FROM userData WHERE uuid=?");
            statement.setString(1, player.getUniqueId().toString());
            ResultSet query = statement.executeQuery();
            query.next();
            int exp = query.getInt("experience");
            return exp;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public static void setExp(OfflinePlayer player, int exp) {
        try {
            Connection connection = DatabaseManager.INSTANCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE userData SET experience=? WHERE uuid=?");
            statement.setInt(1, exp);
            statement.setString(2, player.getUniqueId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addExp(OfflinePlayer player, int exp) {
        addExp(player, exp, "");
    }

    public static void addExp(OfflinePlayer player, int exp, String message) {
        try {
            Connection connection = DatabaseManager.INSTANCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE userData SET experience=experience+? WHERE uuid=?");
            statement.setInt(1, exp);
            statement.setString(2, player.getUniqueId().toString());
            statement.executeUpdate();
            levelCalculate(player);
            if (!message.equals("")) sendExpMessage(player, exp, message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void sendExpMessage(OfflinePlayer player, int exp, String reason) {
        if (!player.isOnline()) return;
        Player onlinePlayer = (Player) player;
        onlinePlayer.sendMessage(Utils.tacc("&a+" + exp + " EXP &7&o" + reason));
    }
}
