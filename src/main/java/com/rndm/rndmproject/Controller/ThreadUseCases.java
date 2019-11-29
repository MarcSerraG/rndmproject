package com.rndm.rndmproject.Controller;

import com.rndm.rndmproject.domain.Category;
import com.rndm.rndmproject.domain.Thread;
import com.rndm.rndmproject.persistence.ThreadDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadUseCases {

        private ThreadDAO threadDAO;

        public ThreadUseCases (ThreadDAO threadDAO){
            this.threadDAO = threadDAO;
        }

        public List<Thread> findFirstTen (){
            return this.threadDAO.findFirstTen();
        }

        public List<Thread> findXThreads(int page){return this.threadDAO.findXThreads(page);}

        public int insert( Thread newthread ){
            return this.threadDAO.insert(newthread);
        }

        public List<Thread> findThreadByCategory ( String Category ){ return this.threadDAO.findThreadByCategory(Category); }

        public List<Thread> findThreadByName (String title) {return this.threadDAO.findThreadByName(title);}

        public List<Thread> findThreadByUser (String user){ return this.threadDAO.findThreadByUser(user); }

        public Thread getThread ( String id ){ return this.threadDAO.getThread(id);}

        public int getCount(String name) {return this.threadDAO.getCount(name);}
        public List<Thread> getTopThreads() { return this.threadDAO.getTopThreads(); }

        public List<String> getTop(){return  this.threadDAO.getTop();}

        public int getTotalThreads(){return this.threadDAO.getTotalThreads();}


}
