package com.example.redesocial.dtos;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@FacesConverter(value = "searchItemConverter", managed = true)
public class SearchItemConverter implements Converter<SearchItemDTO> {

    @Override
    public SearchItemDTO getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) return null;
        String[] ss = s.split(" ");
        return new SearchItemDTO(ss[0], ss[1]);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, SearchItemDTO searchItemDTO) {
        return searchItemDTO == null ? null : searchItemDTO.getNome() + ' ' + searchItemDTO.getType();
    }
}
