package thanh.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import thanh.laptrinhjavaweb.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{
	
}
