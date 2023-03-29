package com.example.cine.find_sala;

import com.example.cine.entities.Sala;
import com.example.cine.entities.SalaFicha;

public interface FindSalaContract {

    public interface View {
        void successFindSala(Sala sala);
        void failureFindSala(String err);
    }

    public interface Model {
        interface OnFindSalaListener {
            void onSuccess(Sala sala);
            void onFailure(String err);
        }
        void findSalaWS(int idSala, FindSalaContract.Model.OnFindSalaListener onFindSalaListener);
    }

    public interface Presenter {
        void findSala(int idSala);
    }
}
