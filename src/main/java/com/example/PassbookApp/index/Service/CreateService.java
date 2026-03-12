package com.example.PassbookApp.index.Service;

import com.example.PassbookApp.index.Entity.CreateEntity;
import com.example.PassbookApp.index.Entity.PassbookEntity;
import com.example.PassbookApp.index.Entity.RegisterEntity;
import com.example.PassbookApp.index.Repository.CreateRepository;
import com.example.PassbookApp.index.Repository.PassbookRepository;
import com.example.PassbookApp.index.Repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateService {
    private final CreateRepository createRepository;
    private final RegisterRepository registerRepository;
    private final PassbookRepository passbookRepository;
    public List<CreateEntity> find(){
        return createRepository.select();
    }

    public List<RegisterEntity> findOpportunity(){return registerRepository.select();}

    public List<PassbookEntity> findPassbook(int year,int month){return passbookRepository.findByYearMonth(year,month);
    }

    public void create(CreateEntity createEntity){
        createRepository.create(createEntity);
        int total = createRepository.sumAmount();

        List<RegisterEntity> list = registerRepository.select();
        if(!list.isEmpty()){
            RegisterEntity latest = list.get(list.size()-1);
            latest.setTotalAmount(total);
            latest.setDifference(total - latest.getTargetAmount());

            registerRepository.register(latest);

        }
    }

    public void register(RegisterEntity registerEntity){
        int total = createRepository.sumAmount();
        registerEntity.setTotalAmount(total);
        registerEntity.setTargetAmount(registerEntity.getTargetAmount());
        registerEntity.setDifference(total - registerEntity.getTargetAmount());
        registerRepository.register(registerEntity);
    }

}
