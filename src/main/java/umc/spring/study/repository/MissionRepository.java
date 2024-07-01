package umc.spring.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByStore (Store store, PageRequest pageRequest);
}
