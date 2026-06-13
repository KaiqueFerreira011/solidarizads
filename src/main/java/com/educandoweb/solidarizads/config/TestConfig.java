package com.educandoweb.solidarizads.config;

import com.educandoweb.solidarizads.entities.Category;
import com.educandoweb.solidarizads.entities.Product;
import com.educandoweb.solidarizads.repositories.CategoryRepository;
import com.educandoweb.solidarizads.repositories.ProductRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        // 1. Instanciando as Categorias de Doação (Gera os IDs 1, 2 e 3)
        Category cat1 = new Category(null, "Alimentos Pereciveis");
        Category cat2 = new Category(null, "Agasalhos e Roupas");
        Category cat3 = new Category(null, "Produtos de Higiene");

        // 2. Instanciando os Produtos/Donativos do Estoque
        Product p1 = new Product(null, "Cesta Basica Tipo A", "Contem arroz, feijao, oleo, macarrao e açúcar.", 90.5, "");
        Product p2 = new Product(null, "Cobertor de Casal", "Cobertor termico de microfibra para o inverno.", 45.0, "");
        Product p3 = new Product(null, "Kit Higiene Pessoal", "Contem pasta de dente, escova, sabonete e xampu.", 25.0, "");
        Product p4 = new Product(null, "Leite Integral UHT", "Caixa com 12 litros de leite de vaca integral.", 60.0, "");
        Product p5 = new Product(null, "Agasalho Moletom G", "Casaco de moletom com capuz para distribuicao.", 70.0, "");

        // 3. Salvando os objetos iniciais no banco H2 para gerar os IDs primários
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // 4. Criando os Relacionamentos Muitos-para-Muitos (Associações)
        p1.getCategories().add(cat1); // Cesta Básica -> Alimentos
        p2.getCategories().add(cat2); // Cobertor -> Agasalhos
        p3.getCategories().add(cat3); // Kit Higiene -> Produtos de Higiene
        p4.getCategories().add(cat1); // Leite -> Alimentos
        p5.getCategories().add(cat2); // Agasalho -> Agasalhos

        // 5. Salvando novamente os produtos com as suas respectivas categorias associadas
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }
}
