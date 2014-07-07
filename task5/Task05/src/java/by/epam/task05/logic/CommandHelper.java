/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.logic;

import by.epam.task05.logic.impl.ParsingXml;
import by.epam.task05.logic.impl.NoSuchCommand;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dima
 */
public class CommandHelper {

    private static final CommandHelper instance = new CommandHelper();
    
    private Map<CommandName,ICommand> commands = new HashMap<>();

    public CommandHelper() {
        commands.put(CommandName.PARSING_XML,new ParsingXml());
        commands.put(CommandName.NO_SUCH_COMMAND,new NoSuchCommand());
    }

    public static CommandHelper getInstance() {
        return instance;
    }

    public ICommand getCommand(String commandName) {
        CommandName name = CommandName.valueOf(commandName.toUpperCase());
        ICommand command;
        
        if (name != null) {
            command = commands.get(name);
        } else {
            command = commands.get(CommandName.NO_SUCH_COMMAND);
        }
        return command;
    }
    
}
