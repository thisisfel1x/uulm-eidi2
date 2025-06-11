package eidi2.sose25.weber.felix.lesson.zulassungsklausur.examA.group01;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examA.group01.util.Tuple;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examA.storage.IStoreable;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examA.storage.Vault;

import java.util.List;
import java.util.LinkedList;

public class VaultingManager {
	final List<Tuple<Bank, List<Vault<IStoreable>>>> banksAndVaults = new LinkedList<>();

	Tuple<Bank, List<Vault<IStoreable>>> findBankTuple(Bank bankToFind) {
		// TODO
		return null;
	}
	
	/**
	 * adds a Vault to the list of vaults associated with a bank
	 * @param bank for which to add the vault
	 * @param vaultToAdd
	 */
	public void addVaultForBank(Bank bank, Vault<IStoreable> vaultToAdd) {
		if(bank == null || vaultToAdd == null) {
			throw new IllegalArgumentException("Neither Bank nor vaultToAdd can be null!");
		}
			
		var bankTuple = findBankTuple(bank);
		
		if(bankTuple == null) {
			bankTuple = new Tuple<>(bank, new LinkedList<Vault<IStoreable>>());
			banksAndVaults.add(bankTuple);
		}
		bankTuple.second.add(vaultToAdd);
	}
	
	public boolean removeValueFromBankVault(Bank bankToFind, long vaultID, int valueToRemove) {
		// TODO
		return false;
	}
	
}
