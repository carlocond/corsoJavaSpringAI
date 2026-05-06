package com.azienda.restLocalitaNuovo.embeddings.config;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.transformers.TransformersEmbeddingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.openai.models.vectorstores.VectorStore;

@Configuration
public class EmbeddingsConfig {

  @Bean
  public EmbeddingModel embeddingModel() {
    // Modello ONNX locale: per semplicità usiamo il default del transformers starter.
    // In base alla release, potresti dover specificare percorso modello.
    return new TransformersEmbeddingModel();
  }

  @Bean
  public VectorStore vectorStore(EmbeddingModel embeddingModel) {
    return new SimpleVectorStore(embeddingModel);
  }
}
