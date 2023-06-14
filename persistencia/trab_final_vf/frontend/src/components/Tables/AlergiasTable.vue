<template>
  <div>
    <md-table :table-header-color="tableHeaderColor">
      <md-table-row slot="md-table-row">
        <template>
          <md-table-cell><strong>ID</strong></md-table-cell>
          <md-table-cell><strong>Nome</strong></md-table-cell>
          <md-table-cell><strong>Excluir</strong></md-table-cell>
        </template>
      </md-table-row>
      <md-table-row
        v-for="(item, index) in alergias"
        :key="index"
        slot="md-table-row"
      >
        <template>
          <md-table-cell>{{ item.id }}</md-table-cell>
          <md-table-cell>{{ item.nome }}</md-table-cell>
          <md-table-cell>
            <md-button
              @click="deleteAlergia(item.id)"
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
  name: "alergias-table",
  props: {
    tableHeaderColor: {
      type: String,
      default: "",
    },
  },
  created() {
    this.getAlergias();
  },
  data: () => ({
    alergias: {},
  }),
  methods: {
    async getAlergias() {
      const response = await this.$axios.get(`http://localhost:8080/alergia`, {
        headers: {},
      });
      this.alergias = response.data;
    },
    async deleteAlergia(id) {
      const response = await this.$axios.delete(
        `http://localhost:8080/alergia/${id}`,
        {
          headers: {},
        }
      );
      this.getAlergias();
    },
  },
};
</script>
