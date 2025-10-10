package org.example.arbeidskravbackend.Bicycle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicycleRepo extends JpaRepository<Bicycle,Long> {

}
