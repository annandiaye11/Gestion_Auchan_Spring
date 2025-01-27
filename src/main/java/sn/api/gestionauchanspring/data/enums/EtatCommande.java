package sn.api.gestionauchanspring.data.enums;

public enum EtatCommande {
    EN_COURS("Encours"),
    EN_ATTENTE("EnAttente"),
    FINALISER("Finaliser");

    private final String value;

    EtatCommande(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EtatCommande fromValue(String value) {
        for (EtatCommande etat : EtatCommande.values()) {
            if (etat.value.equals(value)) {
                return etat;
            }
        }
        throw new IllegalArgumentException("Etat invalide: " + value);
    }
}