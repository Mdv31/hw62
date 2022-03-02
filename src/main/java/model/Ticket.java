package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;


/** Объект тикета (POJO) */

public class Ticket {

    // todo: serialized поля, геттеры и сеттеры
    int priority;
    int id;
    String title="Тестовый запрос";
    int queue=1;
    int status;

    @JsonIgnore
    String due_date = "2022-02-25";
    @JsonIgnore
    String assigned_to ="admin";
    @JsonIgnore
    String created = "2022-01-27T08:26:11.689025";
    @JsonIgnore
    String modified = "2022-01-27T08:26:11.689025";
    @JsonIgnore
    String submitter_email = "test@test.test";
    @JsonIgnore
    boolean on_hold = false;
    @JsonIgnore
    String description = "test";
    @JsonIgnore
    String resolution = "test";
    @JsonIgnore
    String last_escalation = "test";
    @JsonIgnore
    String secret_key = "test";
    @JsonIgnore
    int kbitem = 1;
    @JsonIgnore
    int merged_to = 1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return priority == ticket.priority && id == ticket.id && queue == ticket.queue && status == ticket.status && on_hold == ticket.on_hold && kbitem == ticket.kbitem && merged_to == ticket.merged_to && title.equals(ticket.title) && due_date.equals(ticket.due_date) && assigned_to.equals(ticket.assigned_to) && created.equals(ticket.created) && modified.equals(ticket.modified) && submitter_email.equals(ticket.submitter_email) && description.equals(ticket.description) && resolution.equals(ticket.resolution) && last_escalation.equals(ticket.last_escalation) && secret_key.equals(ticket.secret_key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority, id, title, queue, status, due_date, assigned_to, created, modified, submitter_email, on_hold, description, resolution, last_escalation, secret_key, kbitem, merged_to);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKbitem() {
        return kbitem;
    }

    public void setKbitem(int kbitem) {
        this.kbitem = kbitem;
    }

    public String getLast_escalation() {
        return last_escalation;
    }

    public void setLast_escalation(String last_escalation) {
        this.last_escalation = last_escalation;
    }

    public int getMerged_to() {
        return merged_to;
    }

    public void setMerged_to(int merged_to) {
        this.merged_to = merged_to;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public boolean isOn_hold() {
        return on_hold;
    }

    public void setOn_hold(boolean on_hold) {
        this.on_hold = on_hold;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public String getSubmitter_email() {
        return submitter_email;
    }

    public void setSubmitter_email(String submitter_email) {
        this.submitter_email = submitter_email;
    }
}
