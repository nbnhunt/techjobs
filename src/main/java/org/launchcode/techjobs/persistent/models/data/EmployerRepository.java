package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
}

// 17.3.2: if nothing implements, then CrudRepository stores and retrieves
// create read update delete