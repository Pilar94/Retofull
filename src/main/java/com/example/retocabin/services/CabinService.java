package com.example.retocabin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retocabin.entities.Cabin;
import com.example.retocabin.repositories.CabinRepository;


@Service
public class CabinService {
    
        @Autowired
        private CabinRepository cabinRepository;

        public CabinService(CabinRepository cabinRepository) {
            this.cabinRepository = cabinRepository;
        }

        // METODOS CRUD
        public List<Cabin> getListCabin(){
            return this.cabinRepository.findAll();
        }

        public Cabin getCabin(int id){
            if(!this.cabinRepository.findById(id).isEmpty()){
                return this.cabinRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Cabin crearCabin(Cabin cabin){
            return this.cabinRepository.save(cabin);
        }

        public void eliminarCabin(int id){
            if(!this.cabinRepository.findById(id).isEmpty()){
                this.cabinRepository.deleteById(id);
            }
        }

        public void actualizarCabin(int id, Cabin cabin){
            if(!this.cabinRepository.findById(id).isEmpty()){
                Cabin cabinDB = this.cabinRepository.findById(id).get();
                if(cabin.getName() != null){
                    cabinDB.setName(cabin.getName());
                }
                if(cabin.getBrand() != null){
                    cabinDB.setBrand(cabin.getBrand());
                }
                if(cabin.getRooms() != null){
                    cabinDB.setRooms(cabin.getRooms());
                }
                if(cabin.getDescription() != null){
                    cabinDB.setDescription(cabin.getDescription());
                }
                this.cabinRepository.save(cabinDB);
            }
        }
}
