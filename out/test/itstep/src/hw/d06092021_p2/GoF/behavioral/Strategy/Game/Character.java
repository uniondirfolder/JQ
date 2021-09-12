package hw.d06092021_p2.GoF.behavioral.Strategy.Game;

public abstract class Character {
    String name;
    WeaponBehavior weaponBehavior;

    public abstract void fight();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponBehavior getWeaponBehavior() {
        return weaponBehavior;
    }

    public void setWeapon(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    public void performWeapon() {
        weaponBehavior.useWeapon();
    }

    @Override
    public String toString() {
        return "Character " + name + " has a " + weaponBehavior;
    }
}
