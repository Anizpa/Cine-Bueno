package com.example.cine.list_cines;



import com.example.cine.entities.Cines;

import java.util.List;

public interface ListCinesContract {
    public interface View {
        void successListCines(List<Cines> listCines);

        void failureListCines(String err);
    }

    public interface Model {
        interface OnLstCinesListener {
            void onSuccess(List<Cines> listCines);

            void onFailure(String err);
        }

        void listCinesWS(ListCinesContract.Model.OnLstCinesListener onLstCinesListener);
    }

    public interface Presenter {
        //Caso de uso
        void listCines();
    }
}
