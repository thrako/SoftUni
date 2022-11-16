package lesson04_interfaces.exercise.n06_military;

import lesson04_interfaces.exercise.n06_military.entities.*;
import lesson04_interfaces.exercise.n06_military.enums.Corps;
import lesson04_interfaces.exercise.n06_military.enums.States;
import lesson04_interfaces.exercise.n06_military.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Army {


    private List<Soldier> soldiers = new ArrayList<>();

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void add(String[] tokens) {
        String type = tokens[0];
        SoldierImpl soldier = null;
        switch (type) {
            case "Private":
                soldier = createPrivate(tokens);
                break;
            case "LieutenantGeneral":
                soldier = createLtGen(tokens);
                break;
            case "Engineer":
                soldier = createEngineer(tokens);
                break;
            case "Commando":
                soldier = createCommando(tokens);
                break;
            case "Spy":
                soldier = createSpy(tokens);
                break;
        }

        if (soldier != null) {
            soldiers.add(soldier);
        }
    }

    private PrivateImpl createPrivate(String[] tokens) {
        int idx = 0;
        int id = Integer.parseInt(tokens[++idx]);
        String firstName = tokens[++idx];
        String lastName = tokens[++idx];
        double salary = Double.parseDouble(tokens[++idx]);
        return new PrivateImpl(id, firstName, lastName, salary);
    }

    private LieutenantGeneralImpl createLtGen(String[] tokens) {
        int idx = 0;
        int id = Integer.parseInt(tokens[++idx]);
        String firstName = tokens[++idx];
        String lastName = tokens[++idx];
        double salary = Double.parseDouble(tokens[++idx]);

        LieutenantGeneralImpl ltGen = new LieutenantGeneralImpl(id, firstName, lastName, salary);

        while (idx < tokens.length - 1) {
            int privateID = Integer.parseInt(tokens[++idx]);
            soldiers.stream()
                    .filter(soldier -> soldier.getId() == privateID && soldier instanceof PrivateImpl)
                    .findFirst().ifPresent(soldier -> ltGen.addPrivate((PrivateImpl) soldier));
        }

        return ltGen;
    }

    private EngineerImpl createEngineer(String[] tokens) {
        int idx = 0;
        int id = Integer.parseInt(tokens[++idx]);
        String firstName = tokens[++idx];
        String lastName = tokens[++idx];
        double salary = Double.parseDouble(tokens[++idx]);
        Corps corps = getCorps(tokens[++idx]);
        if (corps == null) {
            return null;
        }

        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corps);

        while (idx < tokens.length - 1) {
            String repairPart = tokens[++idx];
            int repairHours = Integer.parseInt(tokens[++idx]);
            Repair repair = new Repair(repairPart, repairHours);
            engineer.addRepair(repair);
        }

        return engineer;
    }

    private CommandoImpl createCommando(String[] tokens) {
        int idx = 0;
        int id = Integer.parseInt(tokens[++idx]);
        String firstName = tokens[++idx];
        String lastName = tokens[++idx];
        double salary = Double.parseDouble(tokens[++idx]);
        Corps corps = getCorps(tokens[++idx]);
        if (corps == null) {
            return null;
        }

        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corps);

        while (idx < tokens.length - 1) {
            String codeName = tokens[++idx];
            States codeState = getCodeState(tokens[++idx]);
            if (codeState == null) {
                continue;
            }
            commando.addMission(new Mission(codeName, codeState));
        }

        return commando;
    }

    private Corps getCorps(String token) {
        Corps corps;
        try {
            corps = Corps.valueOf(token);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return corps;
    }

    private States getCodeState(String stateString) {
        States state;
        try {
            state = States.valueOf(stateString);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return state;
    }

    private SpyImpl createSpy(String[] tokens) {
        int idx = 0;
        int id = Integer.parseInt(tokens[++idx]);
        String firstName = tokens[++idx];
        String lastName = tokens[++idx];
        String codeNumber = tokens[++idx];

        return new SpyImpl(id, firstName, lastName, codeNumber);
    }

}
