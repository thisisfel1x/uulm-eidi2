package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examA.group01;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examA.storage.IStoreable;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examA.storage.Vault;

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
