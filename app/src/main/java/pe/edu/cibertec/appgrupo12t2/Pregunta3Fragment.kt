package pe.edu.cibertec.appgrupo12t2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo12t2.databinding.FragmentPregunta3Binding

class Pregunta3Fragment : Fragment() {

    private var _binding: FragmentPregunta3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPregunta3Binding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val animales = listOf(
            Animal("Perro", "https://s.yimg.com/ny/api/res/1.2/2p6f8opkr0yasH5UGDS3iA--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD04MDA7Y2Y9d2VicA--/https://media.zenfs.com/en/homerun/feed_manager_auto_publish_494/2f34772cf21588001bef73c25ba02d22"),
            Animal("Gato", "https://s1.static.brasilescola.uol.com.br/be/conteudo/images/Tomilho-Lucy-M.jpg"),
            Animal("León", "https://tse4.mm.bing.net/th/id/OIP.3OzV9gXR2s7hznnRHEjAGAHaE7?r=0&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Tigre", "https://th.bing.com/th/id/OIP.ZL_R-lLNCdKYBcRQQ57OZgHaEV?w=283&h=180&c=7&r=0&o=7&dpr=1.3&pid=1.7&rm=3"),
            Animal("Elefante", "https://tse4.mm.bing.net/th/id/OIP.TLHXuI9a6U6tHcqjCYF5cgHaFj?r=0&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Jirafa", "https://th.bing.com/th/id/OIP.wO-59nwIoU-vb44cuYDFaAHaFj?r=0&o=7rm=3&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Mono", "https://tse1.mm.bing.net/th/id/OIP.G6TSkUEo-n8vFdC7oJgIXQHaE7?r=0&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Oso", "https://tse1.explicit.bing.net/th/id/OIP.bKjwJWAbo388m515yWUW1AHaEc?r=0&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Lobo", "https://th.bing.com/th/id/OIP.kHyDyRXHhnTn9Y2Eipl8TQHaEc?r=0&o=7rm=3&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Zorro", "https://th.bing.com/th/id/R.dd2433930b2546e636b76b8a7ce877b4?rik=hr%2fiE9Xgq1HiVA&riu=http%3a%2f%2f3.bp.blogspot.com%2f-gobEoaqxars%2fTmZIUr80FCI%2fAAAAAAAALVI%2f2vEklTN1IU8%2fs1600%2fZorro-en-su-habitat-natural.jpg&ehk=sbM5JcuqcmWBHl3LjNIfcQ9YUiXY5iROnimzGyv0B%2fs%3d&risl=&pid=ImgRaw&r=0"),
            Animal("Caballo", "https://tse4.mm.bing.net/th/id/OIP.rlwEvc_VCbNQNJEVZk5lTAHaE7?r=0&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Vaca", "https://tse1.mm.bing.net/th/id/OIP.xuI1zz9r-Awt0TazWK59eQHaE8?r=0&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Conejo", "https://tse2.mm.bing.net/th/id/OIP.mVgYGeyp--auc_smQY9SqgHaE7?r=0&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Panda", "https://tse3.mm.bing.net/th/id/OIP.oIg6iiHvM4Pbq9i7kriozAHaE8?r=0&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Cebra", "https://tse4.mm.bing.net/th/id/OIP.Y_wSFZZxTAeZBMv2jyIBRwHaEo?r=0&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Koala", "https://tse1.mm.bing.net/th/id/OIP.rt_Tmgkw7N2Cw0eWAUMmAgHaFa?r=0&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Delfín", "https://tse3.mm.bing.net/th/id/OIP.BJuPQ9UtrVAquhkVuDMrJgHaEK?r=0&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Tortuga", "https://tse2.mm.bing.net/th/id/OIP.ruBCU3FzaTzpt3wwrLyjkAHaE8?r=0&rs=1&pid=ImgDetMain&o=7&rm=3"),
            Animal("Águila", "https://th.bing.com/th/id/R.b132b490edd95817e0319009cfb950e0?rik=Z%2f9fKQxQM1qKoA&riu=http%3a%2f%2fimg1.wikia.nocookie.net%2f__cb20130201010326%2freinoanimalia%2fes%2fimages%2fe%2fea%2fAguila_calva_volando.jpg&ehk=LQwdvyfjq8WjRsDwPsDHR0c1HvMCR4SW%2bmD4CHn1TT8%3d&risl=&pid=ImgRaw&r=0"),
            Animal("Pingüino", "https://i.pinimg.com/736x/33/48/6b/33486b49a669b00d0777359105f2a14b.jpg")
        )

        binding.rvAnimales.layoutManager =
            LinearLayoutManager(requireContext())

        binding.rvAnimales.adapter =
            AnimalAdapter(animales)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}