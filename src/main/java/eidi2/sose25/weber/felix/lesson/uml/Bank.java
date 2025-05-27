package eidi2.sose25.weber.felix.lesson.uml;

import eidi2.sose25.weber.felix.lesson.uml.util.IStoreable;

public class Bank {
    private final VaultingManager REGISTRY;

    public Bank(VaultingManager registry) {
        this.REGISTRY = registry;
    }

    public void addVault(Vault<IStoreable> vaultToAdd) {
        REGISTRY.addVaultForBank(this, vaultToAdd);
    }

    public void removeValueFromVault(long vaultID, int valueToRemove) {
        REGISTRY.removeValueFromBankVault(this, vaultID, valueToRemove);
    }
}
