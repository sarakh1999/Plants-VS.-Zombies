package Model.Card.Plants;

import Controller.GameMode.Battle;
import Model.Map.Cell;

public class PeaOrProjectile {

    private int speedReduction;
    private Cell cell;
    private int damage;//AP per attack
    private int speed=3;
    private boolean backward;
    private boolean prickly;
    private boolean projectile;
    private boolean used = false;

    public PeaOrProjectile(int damage,boolean projectile){
        this.damage=damage;
        this.projectile=projectile;
        this.used = false;
    }

    public PeaOrProjectile(Plant plant) {
        this.damage = plant.getAP();
        this.projectile = plant.pea;
        this.speedReduction = plant.getSpeedReduction();
        this.cell = plant.getCell();
    }
    public void peaMove(Battle battle) {
        int s = this.speed;
        int i = 0;
        int x = this.cell.x();
        int y = this.cell.y();
        while (i < s - 1 && i > 1 && i < 20) {
            if (!this.backward) {
                if (battle.getMap().getCell(x, y + 1).getZombies().isEmpty()) {
                    y++;
                    i++;
                }
            } else {
                if (battle.getMap().getCell(x, y - 1).getZombies().isEmpty()) {
                    y--;
                    i++;
                }
            }
        }


        if (this.backward) {
            if (!battle.getMap().getCell(x, y - 1).getZombies().isEmpty()) {
                battle.getMap().getCell(x, y - 1).getZombies().get(0).setHP(-this.damage);
                this.used = true;
            } else
                this.cell = battle.getMap().getCell(x, y - 1);
        } else {
            if (!battle.getMap().getCell(x, y + 1).getZombies().isEmpty()) {
                battle.getMap().getCell(x, y + 1).getZombies().get(0).setHP(-this.damage);
                this.used = true;
                System.out.println("Used ???????????????????????????????????????????????????????????");
                //todo
            } else
                this.cell = battle.getMap().getCell(x, y + 1);
        }
    }


    public Cell getCell(){
        return cell;
    }

    public void setCell(Cell cell){
        this.cell=cell;
    }

    public void setX(int x) {
        this.cell.setX(x);
    }

    public void setY(int y) {
        this.cell.setY(y);
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isPrickly() {
        return prickly;
    }

    public boolean isProjectile() {
        return projectile;
    }

    public void setBackward(boolean b) {
        backward = b;
    }
}
