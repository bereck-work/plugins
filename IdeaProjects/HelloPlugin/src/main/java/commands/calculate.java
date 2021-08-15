package commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class calculate implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {return true;}
        Player player = (Player) commandSender;

        if (strings.length != 2) {
            player.sendMessage("§6[§eHelloPlugin§6] §cIncorrect usage of the command. Use: /calcuate <value one> <value two>");
        } else {
            String firstNumberString = strings[0];
            String secondNumberString = strings[1];

            try {
                int firstNumber = Integer.parseInt(firstNumberString);
                int secondNumber = Integer.parseInt(secondNumberString);
                int solution = firstNumber + secondNumber;
                player.sendMessage(ChatColor.BLUE + firstNumberString + " + " + secondNumberString + " = " + solution);
            } catch(Exception e) {
                player.sendMessage("§6[§eHelloPlugin§6] §cError occured while executing the command. Check if all arguments are valid.");
            }

        }

        return true;
    }
}
