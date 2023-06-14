<template>
  <div>
    <md-table :table-header-color="tableHeaderColor">
      <md-table-row slot="md-table-row">
        <template>
          <md-table-cell><strong>Nome</strong></md-table-cell>
          <md-table-cell><strong>Data de Nascimento</strong></md-table-cell>
          <md-table-cell><strong>Sexo</strong></md-table-cell>
          <md-table-cell><strong>Logradouro</strong></md-table-cell>
          <md-table-cell><strong>Número</strong></md-table-cell>
          <md-table-cell><strong>Setor</strong></md-table-cell>
          <md-table-cell><strong>Cidade</strong></md-table-cell>
          <md-table-cell><strong>UF</strong></md-table-cell>
        </template>
      </md-table-row>
      <md-table-row
        v-for="(usuario, index) in usuario"
        :key="index"
        slot="md-table-row"
        @click="linkToUser(usuario.id)"
      >
        <md-table-cell>{{ usuario.nome }}</md-table-cell>
        <md-table-cell>{{ usuario.dataNascimento }}</md-table-cell>
        <md-table-cell>{{
          usuario.sexo == "m" ? "Masculino" : "Feminino"
        }}</md-table-cell>
        <md-table-cell>{{ usuario.logradouro }}</md-table-cell>
        <md-table-cell>{{ usuario.numero }}</md-table-cell>
        <md-table-cell>{{ usuario.setor }}</md-table-cell>
        <md-table-cell>{{ usuario.cidade }}</md-table-cell>
        <md-table-cell>{{ usuario.uf }}</md-table-cell>
        <md-table-cell>Ver detalhes</md-table-cell>
      </md-table-row>
    </md-table>
  </div>
</template>

<script>
export default {
  name: "simple-table",
  props: {
    tableHeaderColor: {
      type: String,
      default: "",
    },
    usuario: null,
  },
  data() {
    return {
      selected: [],
    };
  },
  methods: {
    linkToUser(id) {
      this.$router.push({ name: "VisualizarUsuarioPorId", params: { id } });
    },
    async deleteUsuario(id) {
      const response = await this.$axios.delete(
        `http://localhost:8080/usuario/${id}`,
        {
          headers: {},
        }
      );
    },
  },
};
</script>

<style>
.md-table-row {
  cursor: pointer;
}
</style>
