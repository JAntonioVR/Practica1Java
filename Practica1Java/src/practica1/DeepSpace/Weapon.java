
package DeepSpace;

/**
 *
 * @author Pedro Pablo Ruiz Huertas y Juan Antonio Villegas Recio
 */
public class Weapon {
    private String name;
    private WeaponType type;
    private int uses;
    
    public Weapon(String new_name, WeaponType new_type, int new_uses ){
        name=new_name;
        type=new_type;
        uses=new_uses;
    }
    
    public Weapon(Weapon s){
        name=s.name;
        type=s.type;
        uses=s.uses;
    }
    
    public WeaponType getType(){
        return type;
    }
    
    public int getUses(){
        return uses;
    }
    
    public float power(){
        return type.getPower();
    }
    
    public float useIt(){
        if(uses>0){
            uses--;
            return power();
        }
        else{
            return 1.0f;
        }
    }
    
    
}