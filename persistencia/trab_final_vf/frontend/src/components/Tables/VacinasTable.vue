<template>
  <div>
    <md-table :table-header-color="tableHeaderColor">
      <md-table-row slot="md-table-row">
        <template>
          <md-table-cell><strong>Título</strong></md-table-cell>
          <md-table-cell><strong>Descrição</strong></md-table-cell>
          <md-table-cell><strong>Doses</strong></md-table-cell>
          <md-table-cell><strong>Intervalo</strong></md-table-cell>
          <md-table-cell><strong>Periodicidade</strong></md-table-cell>
          <md-table-cell><strong>Excluir</strong></md-table-cell>
        </template>
      </md-table-row>
      <md-table-row
        v-for="(item, index) in vacinas"
        :key="index"
        slot="md-table-row"
      >
        <template>
          <md-table-cell>{{ item.titulo }}</md-table-cell>
          <md-table-cell>{{ item.descricao }}</md-table-cell>
          <md-table-cell>{{ item.doses }}</md-table-cell>
          <md-table-cell>{{ item.intervalo }}</md-table-cell>
          <md-table-cell>{{ item.periodicidade }}</md-table-cell>
          <md-table-cell>
            <md-button
              @click="deleteVacina(item.id)"
              class="md-raised md-danger"
            >
              <md-icon>delete</md-icon>
            </md-button>
          </md-table-cell>
        </template>
      </md-table-row>
    </md-table>
  </div>
</template>

<script>
export default {
  name: "agendamentos-table",
  props: {
    tableHeaderColor: {
      type: String,
      default: "",
    },
  },
  created() {
    this.getVacinas();
  },
  data: () => ({
    vacinas: {},
  }),
  methods: {
    async getVacinas() {
      const response = await this.$axios.get(`http://localhost:8080/vacina`, {
        headers: {},
      });
      this.vacinas = response.data;
    },
    async deleteVacina(id) {
      const response = await this.$axios.delete(
        `http://localhost:8080/vacina/${id}`,
        {
          headers: {},
        }
      );
      this.getVacinas();
    },
  },
};
</script>
