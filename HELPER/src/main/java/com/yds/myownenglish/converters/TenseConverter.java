package com.yds.myownenglish.converters;

import com.yds.myownenglish.dtos.TenseDTO;
import com.yds.myownenglish.entities.TenseEntity;
import com.yds.myownenglish.entities.TypeEntity;
import com.yds.myownenglish.models.TenseModel;
import com.yds.myownenglish.models.TenseTypeModel;

import java.util.ArrayList;
import java.util.List;

public class TenseConverter {

    public static List<TenseDTO> convertFromModel(TenseModel tenseModel){
        List<TenseDTO> tenseDTOList = new ArrayList<>();
        for (TenseTypeModel tenseTypeModel : tenseModel.getTenseTypeModelList()){
            tenseDTOList.add(TenseDTO.builder()
                    .tenseName(tenseModel.getTenseName().concat(" ").concat(tenseTypeModel.getTypeName()))
                    .build()
            );
        }
        return tenseDTOList;
    }

    public static List<TenseDTO> convertFromModel(List<TenseModel> tenseModel){
        List<TenseDTO> tenseDTOList = new ArrayList<>();
        for (TenseModel currentTenseModel : tenseModel){
            tenseDTOList.addAll(convertFromModel(currentTenseModel));
        }
        return tenseDTOList;
    }

    public static List<TenseModel> convertFromEntity(List<TenseEntity> tenseEntities){
        List<TenseModel> tenseModels = new ArrayList<>();
        for (TenseEntity curr: tenseEntities){
            if (tenseModels.stream().noneMatch(c -> c.getTenseId().equals(curr.getTenseId()))){
                List<TypeEntity> types = tenseEntities.stream()
                        .filter(c -> c.getTenseId().equals(curr.getTenseId())).toList().stream()
                        .map(TenseEntity::getTenseType).toList();

                TenseModel model = TenseModel.builder()
                        .tenseId(curr.getTenseId())
                        .tenseName(curr.getTenseName())
                        .tenseTypeModelList(TypeConverter.convertFromEntity(types))
                        .build();
                tenseModels.add(model);
            }
        }
        return tenseModels;
    }

}
