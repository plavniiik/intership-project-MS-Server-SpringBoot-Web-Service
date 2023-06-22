package com.example.intership31conly.Reposiroty.dbone;

import com.example.intership31conly.Model.dbone.Indicators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicatorsRepository extends JpaRepository<Indicators,Long> {
}
