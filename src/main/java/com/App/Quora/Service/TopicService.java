package com.App.Quora.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.App.Quora.Repository.TopicRepository;
import com.App.Quora.Entity.Topic;
import com.App.Quora.ExceptionHandler.BadRequestException;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRespository;
    
    public Page<?> getAllTopics()
    {
        Pageable pageable=PageRequest.of(0, 10,Sort.by("name").ascending());
        return topicRespository.findAll(pageable);
    }
    public Topic saveTopic(Topic topic)
    {
        if(topicRespository.existsByName(topic.getName()))
        {
            throw new BadRequestException("Topic already exists");
        }
        return topicRespository.save(topic);
    }
}
