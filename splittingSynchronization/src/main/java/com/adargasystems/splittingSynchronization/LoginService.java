/*
 *
 */
package com.adargasystems.splittingSynchronization;

import com.adargasystems.splittingSynchronization.ServiceResult.ServiceResultEnum;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class LoginService implements Service {

	public ServiceResult perform() {
		System.out.println("Performing LoginService...");
		return new ServiceResult(ServiceResultEnum.SUCCESS);
	}

}
