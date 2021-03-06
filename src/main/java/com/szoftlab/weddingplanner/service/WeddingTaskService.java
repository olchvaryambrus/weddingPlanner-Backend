package com.szoftlab.weddingplanner.service;

import com.szoftlab.weddingplanner.model.WeddingTask;
import com.szoftlab.weddingplanner.repository.WeddingTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WeddingTaskService {


    private WeddingTaskRepository repository;

    @Autowired
    public WeddingTaskService(WeddingTaskRepository weddingTaskRepository) { this.repository = weddingTaskRepository; }

    public List<WeddingTask> findAll(){
        return repository.findAll();
    }

    public Optional<WeddingTask> findById(Long Id){
        return repository.findById(Id);
    }

    public List<WeddingTask> findByGroupId(Long id) { return repository.findByGroupIdOrderById(id); }

    public long countAll() { return repository.count(); }

    public long countByIsDoneTrue() { return repository.countByIsDoneTrue(); }

    public List<Long> getCountList() {
        List<Long> list = new ArrayList<>();
        list.add(repository.count());
        list.add(repository.countByIsDoneTrue());
        return list;
    }

    public Iterable<WeddingTask> saveAll(Iterable<WeddingTask> newTasks) { return repository.saveAll(newTasks); }

    public WeddingTask save(WeddingTask newTask){
        return repository.save(newTask);
    }

    public void deleteById(Long Id){
        repository.deleteById(Id);
    }

    public void deleteAll(List<WeddingTask> taskList) { repository.deleteAll(taskList); }
}
