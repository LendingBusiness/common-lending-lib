package org.kd.repository;

import org.kd.model.LegalEntity;
import java.util.List;

public interface LegalEntityRepository {

    List<LegalEntity> getAll();

    public void create(String name);
}
