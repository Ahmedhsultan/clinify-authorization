package com.example.clinifyauthorization.persistence.reposatory;

import com.example.clinifyauthorization.persistence.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Integer> {

}
