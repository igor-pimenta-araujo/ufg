<template>
  <div>
    <md-button @click="getAgendamentosRealizados" class="md-raised md-danger"
      >Agendamentos Realizados</md-button
    >
    <md-button @click="getAgendamentos" class="md-raised md-danger"
      >Todos os agendamentos</md-button
    >
    <md-button @click="getAgendamentosDoDia" class="md-raised md-danger"
      >Agendamentos do dia</md-button
    >
    <md-button @click="getAgendamentosCancelados" class="md-raised md-danger"
      >Agendamentos Cancelados</md-button
    >
    <md-table :table-header-color="tableHeaderColor">
      <md-table-row slot="md-table-row">
        <template>
          <md-table-cell><strong>Data</strong></md-table-cell>
          <md-table-cell><strong>Hora</strong></md-table-cell>
          <md-table-cell><strong>Situação</strong></md-table-cell>
          <md-table-cell><strong>Data Situação</strong></md-table-cell>
          <md-table-cell><strong>Observações</strong></md-table-cell>
          <md-table-cell><strong>Vacina</strong></md-table-cell>
          <md-table-cell><strong>Usuário</strong></md-table-cell>
          <md-table-cell><strong>Data Nascimento</strong></md-table-cell>
          <md-table-cell><strong>Realizada</strong></md-table-cell>
          <md-table-cell><strong>Cancelada</strong></md-table-cell>
          <md-table-cell><strong>Excluir</strong></md-table-cell>
        </template>
      </md-table-row>
      <md-table-row
        v-for="(item, index) in agendamentos"
        :key="index"
        slot="md-table-row"
      >
        <template>
          <md-table-cell>{{ item.data }}</md-table-cell>
          <md-table-cell>{{ item.hora }}</md-table-cell>
          <md-table-cell>{{ item.situacao }}</md-table-cell>
          <md-table-cell>{{ item.dataSituacao }}</md-table-cell>
          <md-table-cell>{{ item.observacoes }}</md-table-cell>
          <md-table-cell>{{ item.vacina.titulo }}</md-table-cell>
          <md-table-cell>{{ item.usuario.nome }}</md-table-cell>
          <md-table-cell>{{ item.usuario.dataNascimento }}</md-table-cell>
          <md-table-cell>
            <md-checkbox
              v-model="item.situacao"
              :value="'Realizado'"
              :disabled="
                item.situacao === 'Cancelado' || item.situacao === 'Realizado'
              "
              @change="updateAgendamentoRealizado(item)"
            ></md-checkbox>
          </md-table-cell>
          <md-table-cell>
            <md-checkbox
              v-model="item.situacao"
              :value="'Cancelado'"
              :disabled="
                item.situacao === 'Cancelado' || item.situacao === 'Realizado'
              "
              @change="updateAgendamentoCancelado(item)"
            ></md-checkbox>
          </md-table-cell>
          <md-table-cell>
            <md-button
              @click="deleteAgendamento(item.id)"
              :disabled="item.situacao !== 'Agendado'"
              class="md-raised md-danger"
              >excluir</md-button
            >
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
    items: {},
  },
  created() {
    this.getAgendamentos();
  },
  data: () => ({
    agendamentos: {},
    type: ["", "info", "success", "warning", "danger"],
  }),
  methods: {
    async getAgendamentos() {
      const response = await this.$axios.get(`http://localhost:8080/agenda`, {
        headers: {},
      });
      this.agendamentos = response.data;
    },
    async getAgendamentosDoDia() {
      const response = await this.$axios.get(
        `http://localhost:8080/agenda/data?data=${new Date()
          .toISOString()
          .slice(0, 10)}`,
        {
          headers: {},
        }
      );
      this.agendamentos = response.data;
    },
    async getAgendamentosRealizados() {
      const response = await this.$axios.get(
        `http://localhost:8080/agenda/situacao?situacao=Realizado`,
        {
          headers: {},
        }
      );
      this.agendamentos = response.data;
    },
    async getAgendamentosCancelados() {
      const response = await this.$axios.get(
        `http://localhost:8080/agenda/situacao?situacao=Cancelado`,
        {
          headers: {},
        }
      );
      this.agendamentos = response.data;
    },
    async updateAgendamentoRealizado(item) {
      let observacao = window.prompt("Digite as observações");
      const response = await this.$axios.put(
        `http://localhost:8080/agenda/situacao?situacao=Realizado&id=${item.id}&observacoes=${observacao}`
      );
      this.getAgendamentos();
      this.notifyVue("top", "right");
    },
    async updateAgendamentoCancelado(item) {
      let observacao = window.prompt("Digite as observações");
      const response = await this.$axios.put(
        `http://localhost:8080/agenda/situacao?situacao=Cancelado&id=${item.id}&observacoes=${observacao}`
      );
      this.getAgendamentos();
      this.notifyVue("top", "right");
    },
    notifyVue(verticalAlign, horizontalAlign) {
      var color = Math.floor(Math.random() * 4 + 1);
      this.$notify({
        message: "Item atualizado.",
        icon: "add_alert",
        horizontalAlign: horizontalAlign,
        verticalAlign: verticalAlign,
        type: "info",
      });
    },
    async deleteAgendamento(id) {
      const response = await this.$axios.delete(
        `http://localhost:8080/agenda/${id}`
      );
      this.getAgendamentos();
      this.notifyVue("top", "right");
    },
  },
};
</script>
