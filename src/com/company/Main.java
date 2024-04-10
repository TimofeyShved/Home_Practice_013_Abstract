package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Reciver reciver = new Reciver();
        reciver.addComands(new AddUndoStringbilder());
        reciver.addComands(new DeleteUndoStringbilder());
        reciver.undo();
    }
}

// данный паттерн создаёт отдельную обвёртку вызываемых команд, точнее классов у которых есть внутрениие действия. А обёртка помогает создавать и выполнять их намного быстрее
interface Command{
    void execute();
}

class AddUndoStringbilder implements Command{
    @Override
    public void execute() {
        System.out.println("допустип добавим строку");
    }
}

class DeleteUndoStringbilder implements Command{
    @Override
    public void execute() {
        System.out.println("допустип удалим строку");
    }
}


class Reciver{
    List<Command> commands = new ArrayList<Command>();

    void addComands(Command command){
        commands.add(command);
    }

    void undo(){
        for (Command command:commands){
            command.execute();
        }
    }
}
