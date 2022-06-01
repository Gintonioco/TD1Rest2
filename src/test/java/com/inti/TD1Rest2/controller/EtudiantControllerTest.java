package com.inti.TD1Rest2.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.inti.TD1Rest2.model.Etudiant;
import com.inti.TD1Rest2.repository.EcoleRepository;
import com.inti.TD1Rest2.repository.EtudiantRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EtudiantController.class)
public class EtudiantControllerTest
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EtudiantRepository etudiantRepository;
	
	@MockBean
	private EcoleRepository ecoleRepository;
	
	@Test
	public void testGetAllStudents()
	{
		try
		{
			mockMvc.perform(get("/students"))
			.andExpect(status().isOk());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSaveStudent()
	{
		try
		{
			Etudiant etudiant;
			mockMvc.perform(post("/saveStudent"))
			.andExpect(status().isCreated());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
