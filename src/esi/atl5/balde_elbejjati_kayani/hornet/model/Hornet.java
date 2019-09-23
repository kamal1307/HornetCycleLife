package esi.atl5.balde_elbejjati_kayani.hornet.model;

/**
 * reprensente hornet
 *
 * @author Alpha,Mohamed,Kamal
 */
public class Hornet {

    private boolean aLive;
    private  Sexe sexe;
    private  Role role;
    private int age;

    /**
     * constructor of a hornet
     * @param sexe a sex
     * @param saison a season 
     */
    public Hornet(Sexe sexe, Season saison) {
        
         age = 0;
        this.sexe = sexe;
        if (saison == Season.WINTER && sexe == Sexe.FEMALE) {
            role = Role.FOUNDER;
            this.aLive = true;
        } else if (saison != Season.WINTER && sexe == Sexe.FEMALE) {
            role = Role.FACTORY;
            this.aLive = saison != Season.WINTER;
        } else {
            role = Role.COUPLING;
            this.aLive = saison != Season.WINTER;
        }
        
    }

    /**
     * getter of sex
     * @return a sex
     */
    public Sexe getSexe() {
        return sexe;
    }

    /**
     * getter of role
     * @return a role
     */
    public Role getRole() {
        return role;
    }

    /**
     * getter of age
     * @return an age
     */
    public int getAge() {
        return age;
    }

   
    /**
     * Check state of frelon
     *
     * @return State of  hornet
     */
    public boolean isALive() {
        return aLive;
    }

    /**
     * Change state of frelon.
     *
     * @param estVivant new state of hornet.
     */
    public void setAlive(boolean estVivant) {
        this.aLive = estVivant;
        if(!estVivant){
            age=0;
        }else{
            age=1;
        }
    }

    /**
     * setter age
     * increments age
     */
    public void setAge() {
       if(!aLive){
           age=-1;
       }else{
           age = age + 1;
       }
       
    }

    /**
     * setter sex
     * @param sexe a new sex
     */
    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    /**
     * setter role
     * @param role a new role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    
}
