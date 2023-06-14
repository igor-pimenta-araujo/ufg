<template>
  <div class="content">
    <div class="md-layout">
      <div
        class="md-layout-item md-medium-size-100 md-xsmall-size-100 md-size-100"
      >
        <md-card>
          <md-card-header data-background-color="green">
            <h4 class="title">Usuários</h4>
          </md-card-header>
          <md-card-content>
            <user-table :usuario="this.usuario" table-headere-color="green">
            </user-table>
          </md-card-content>
        </md-card>
      </div>
    </div>
  </div>
</template>

<script>
import { UserTable } from "@/components";
export default {
  components: {
    UserTable,
  },
  data: () => ({
    usuario: {
      nome: "",
      dataNascimento: "",
      sexo: "",
      logradouro: "",
      numero: "",
      setor: "",
      cidade: "",
      uf: "",
    },
  }),
  created() {
    this.getUsuario();
  },
  methods: {
    async getUsuario() {
      const response = await this.$axios.get(`http://localhost:8080/usuario`, {
        headers: {},
      });
      this.usuario = response.data;
    },
  },
};
</script>
